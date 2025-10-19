<script>
    import { Combobox } from "bits-ui";
    import CaretUpDown from "phosphor-svelte/lib/CaretUpDown";
    import Check from "phosphor-svelte/lib/Check";
    import OrangeSlice from "phosphor-svelte/lib/OrangeSlice";
    import CaretDoubleUp from "phosphor-svelte/lib/CaretDoubleUp";
    import CaretDoubleDown from "phosphor-svelte/lib/CaretDoubleDown";
    import AirTrafficControl from "phosphor-svelte/lib/AirTrafficControl";

    let {airports} = $props();

    let airportOptions = $derived(airports.map(airport => ({value: airport.iata, label: `${airport.city} (${airport.iata})`})));

    let searchValue = $state("");

    // Absolutely need to re-work on that search! To slow when inputting the first letter.
    // Probably need to do it in the BE or use a library (like fuse.js)
    const filteredAirports = $derived(
        searchValue === ""
            ? airportOptions
            : airportOptions.filter((airport) =>
                airport.label.toLowerCase().includes(searchValue.toLowerCase())
            )
    );
</script>

<Combobox.Root
        type="multiple"
        name="favoriteFruit"
        onOpenChange={(o) => {
    if (!o) searchValue = "";
  }}
>
    <div class="relative w-64">
        <AirTrafficControl
                class="absolute left-3 top-1/2 -translate-y-1/2 size-5 <text-base-content> pointer-events-none"
        />

        <Combobox.Input
                oninput={(e) => (searchValue = e.currentTarget.value)}
                class="w-64 h-12 px-12 py-2 border-2 border-primary rounded-md text-center text-base placeholder:text-center placeholder:text-base-content focus:outline-none focus:ring-2 focus:ring-primary transition"
                placeholder="Select your airport"
                aria-label="Select your airport"
        />

        <Combobox.Trigger
                class="absolute right-3 top-1/2 -translate-y-1/2 size-6"
        >
            <CaretUpDown class="text-base-content size-5" />
        </Combobox.Trigger>
    </div>

    <Combobox.Portal>
        <Combobox.Content
                class="z-50 mt-2 rounded-xl border border-primary bg-base-100 shadow-lg max-h-96 w-[var(--bits-combobox-anchor-width)] min-w-[var(--bits-combobox-anchor-width)] overflow-y-auto"
                sideOffset={10}
        >
            <Combobox.ScrollUpButton class="flex w-full items-center justify-center py-1">
                <CaretDoubleUp class="size-3" />
            </Combobox.ScrollUpButton>

            <Combobox.Viewport class="p-1">
                {#each filteredAirports as airport, i (i + airport.value)}
                    <Combobox.Item
                            class="flex items-center justify-between px-5 py-2 text-sm capitalize rounded-md cursor-pointer hover:bg-primary hover:text-accent-content"
                            value={airport.value}
                            label={airport.label}
                    >
                        {#snippet children({ selected })}
                            {airport.label}
                        {/snippet}
                    </Combobox.Item>
                {:else}
          <span class="block px-5 py-2 text-sm text-base-content/50">
            No results found, try again.
          </span>
                {/each}
            </Combobox.Viewport>

            <Combobox.ScrollDownButton class="flex w-full items-center justify-center py-1">
                <CaretDoubleDown class="size-3" />
            </Combobox.ScrollDownButton>
        </Combobox.Content>
    </Combobox.Portal>
</Combobox.Root>