<script>
    import Hero from "$lib/components/landingPage/Hero.svelte";
    import BentoDestinations from "$lib/components/landingPage/BentoDestinations.svelte";

    let { data } = $props();
</script>

<Hero airports={data.airports}/>
<BentoDestinations popularAirports={data.popularAirports}/>
