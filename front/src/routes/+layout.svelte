<script>
	import '../app.css';
    import {page} from '$app/stores';
	import Navbar from "$lib/components/Navbar.svelte";

    /** @type {import('./$types').LayoutProps} */
	let { data, children } = $props();

    let hideNavBar = $derived($page.route.id === '/login');
</script>

{#if !hideNavBar}
    <Navbar user={data.user}/>
{/if}

{@render children()}
