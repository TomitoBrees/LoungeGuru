export async function getAllAirports(cacheData) {
    let now = Date.now()
    if (! cacheData.cachedAirports || now - cacheData.lastCached > cacheData.cachedLifetime ) {
        const airportsRes = await fetch('http://localhost:8080/airports', {
            method: 'GET',
        })

        let airportsData = airportsRes.json();
        cacheData.cachedAirports = airportsData;
        cacheData.lastCached = now;

        return airportsData;
    }
    else
    {
        return cacheData.cachedAirports;
    }
}

export async function getPopularAirports() {
    const popularAirportRes = await fetch('http://localhost:8080/airports/popular',
        {method: 'GET'}
    );

    return popularAirportRes.json();
}

export async function getAirportFromIata(iata) {
    const airport = await fetch(
        `http://localhost:8080/airports`,
        {
            method: 'POST',
            body: JSON.stringify({iata: iata.toString()}),
            headers: {
                'Content-Type': 'application/json'
            },
        });

    if (!airport.ok) {
        console.error(`Request failed with status ${airport.status}`);
        return null;
    }

    const data = await airport.json();
    return data;
}