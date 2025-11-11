<script>
    import DestinationCard from "$lib/components/landingPage/DestinationCard.svelte";

    let {popularAirports} = $props();

    let popularAirportsInfo = $derived(popularAirports.map(airport => ({city: airport.city, image: airport.image, ranking: airport.ranking})))

    const cards =$derived( [
        { airportInfos: popularAirportsInfo[0] ,spanCols: 2 },
        { airportInfos: popularAirportsInfo[1] ,spanCols: 3 },
        { airportInfos: popularAirportsInfo[7] ,spanCols: 4 },
        { airportInfos: popularAirportsInfo[3],spanCols: 3 },
        { airportInfos: popularAirportsInfo[4],spanCols: 3 },
        { airportInfos: popularAirportsInfo[5],spanCols: 4 },
        { airportInfos: popularAirportsInfo[6],spanCols: 3 },
        { airportInfos: popularAirportsInfo[2],spanCols: 2 },
    ]);
</script>

<div class="mx-16 bg-base-200 rounded-md border border-base-300">
    <p class="text-2xl px-6 pt-6">Popular destinations 🔥</p>
    <div class=" grid grid-cols-12 auto-rows-[minmax(0,300px)] gap-4 p-6">

        {#each cards as card, index}
            <DestinationCard {...card} cardId={index}/>
        {/each}
    </div>
</div>