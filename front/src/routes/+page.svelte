<script>
    import Hero from "$lib/components/Hero.svelte";
    import BentoDestinations from "$lib/components/BentoDestinations.svelte";

    let { data } = $props();
</script>

<Hero airports={data.airports}/>
<BentoDestinations />
