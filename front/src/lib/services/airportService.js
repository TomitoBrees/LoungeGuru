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