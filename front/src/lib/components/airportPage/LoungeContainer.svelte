<script>
    import LoungeCard from "$lib/components/airportPage/LoungeCard.svelte";

    let {lounges} = $props();
</script>

<div class="flex flex-col gap-5 p-10">
    {#each lounges as lounge}
        <LoungeCard lounge={lounge} />
    {/each}
    <LoungeCard />
    <LoungeCard />
</div>