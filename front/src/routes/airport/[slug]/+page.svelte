<script>
    import AirportHeader from "$lib/components/airportPage/AirportHeader.svelte";
    import LoungeCard from "$lib/components/airportPage/LoungeCard.svelte";
    import LoungeContainer from "$lib/components/airportPage/LoungeContainer.svelte";

    let {data} = $props();
</script>

<AirportHeader airport={data}/>
<LoungeContainer />