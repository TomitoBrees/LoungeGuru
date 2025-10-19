<script>
    import AirportInput from "$lib/components/AirportInput.svelte";
    import DateInput from "$lib/components/DateInput.svelte";

    let { airports } = $props()
</script>

<header class="hero relative mb-24">

    <img src="/illustrations/left-illustration.svg"
         alt="a woman with airborne objects"
         class="hidden md:block absolute left-1/4 pb-12 transform -translate-x-[40%]"
    />

    <img src="/illustrations/right-illustration.svg"
         alt="man at the airport"
         class="hidden md:block absolute right-1/4 pb-12 transform translate-x-[40%]"
    />

    <div class="hero-content text-center">
        <div class="max-w-md">
            <h1 class="text-3xl font-bold leading-[103%]">Book your lounge easily<br>Get comfortable rapidly</h1>
            <p class="mt-2 mb-4 text-2xl font-light italic">
                Skip the crowds, relax before your flight
            </p>
            <div class="flex gap-32 justify-center">
                <AirportInput airports={airports}/>
                <DateInput />
            </div>
        </div>
    </div>
</header>