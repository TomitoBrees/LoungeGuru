<script>
	import '../app.css';
    import {page} from '$app/stores';
	import Navbar from "$lib/components/Navbar.svelte";

	let { children } = $props();

    let hideNavBar = $derived($page.route.id === '/login');
</script>

{#if !hideNavBar}
    <Navbar />
{/if}

{@render children()}
