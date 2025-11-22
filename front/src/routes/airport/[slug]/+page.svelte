<script>
    import AirportHeader from "$lib/components/airportPage/AirportHeader.svelte";
    import LoungeContainer from "$lib/components/airportPage/LoungeContainer.svelte";

    let {data} = $props();
</script>

<AirportHeader airport={data}/>
<LoungeContainer lounges={data.lounges}/>