<script>
    import MapPin from "phosphor-svelte/lib/MapPin";
    import Armchair from "phosphor-svelte/lib/Armchair";
    import Coins from "phosphor-svelte/lib/Coins";
    import Star from "phosphor-svelte/lib/Star";

    import DataCard from "$lib/components/airportPage/DataCard.svelte";

    import {countryFlags} from "$lib/services/flagService.js";

    let {airport} = $props();
</script>

<div class="hero bg-primary/10 min-h-80">
    <div class="hero-content px-34 min-w-screen flex-col lg:flex-row-reverse justify-between">
        <img
                src={airport.image}
                class="max-w-sm rounded-lg shadow-2xl"
                alt="airport"
        />
        <div class="flex flex-col gap-8">
            <div class="flex flex-col gap-2">
                <h1 class="text-5xl font-normal"> {countryFlags[airport.country]} {airport.name}</h1>
                <span class="flex items-center gap-2 text-secondary">
                    <MapPin class="inline"/>
                    {airport.country}
                </span>
            </div>

            <div class="flex h-24 justify-between gap-10">
                <DataCard label="Available Lounges">
                    {#snippet icon()}
                        <Armchair class="inline text-primary" weight="bold"/>
                    {/snippet}
                    {#snippet value()}
                        6
                    {/snippet}
                </DataCard>

                <DataCard label="Skytrax Rating">
                    {#snippet icon()}
                        <Star class="inline text-primary" weight="bold"/>
                    {/snippet}
                    {#snippet value()}
                        <div class="rating">
                            <input type="radio" name="rating-4" class="mask mask-star-2 bg-primary" aria-label="1 star" />
                            <input type="radio" name="rating-4" class="mask mask-star-2 bg-primary" aria-label="2 star" checked="checked" />
                            <input type="radio" name="rating-4" class="mask mask-star-2 bg-primary" aria-label="3 star" />
                            <input type="radio" name="rating-4" class="mask mask-star-2 bg-primary" aria-label="4 star" />
                            <input type="radio" name="rating-4" class="mask mask-star-2 bg-primary" aria-label="5 star" />
                        </div>
                    {/snippet}
                </DataCard>

                <DataCard label="Starting Price">
                    {#snippet icon()}
                        <Coins class="inline text-primary" weight="bold"/>
                    {/snippet}
                    {#snippet value()}
                        35€
                    {/snippet}
                </DataCard>
            </div>
        </div>
    </div>
</div>
