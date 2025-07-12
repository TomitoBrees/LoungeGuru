<script>
    import DestinationCard from "$lib/components/DestinationCard.svelte";

    const cards = [
        { title: 'London', spanCols: 2 },
        { title: 'Beijing', spanCols: 3 },
        { title: 'Singapore', spanCols: 4 },
        { title: 'Dubai', spanCols: 3, spanRows: 2 },
        { title: 'Paris', spanCols: 3 },
        { title: 'New York', spanCols: 4 },
        { title: 'Sydney', spanCols: 2 },
    ];
</script>

<div class="mx-16 bg-base-200 rounded-md border border-base-300">
    <p class="text-2xl px-6 pt-6">Popular destinations 🔥</p>
    <div class=" grid grid-cols-12 auto-rows-[minmax(0,300px)] gap-4 p-6">

        {#each cards as card, index}
            <DestinationCard {...card} cardId={index}/>
        {/each}
    </div>
</div>