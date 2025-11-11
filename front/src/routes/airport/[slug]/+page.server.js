import {getAirportFromIata} from '$lib/services/airportService.js';
import {error} from "@sveltejs/kit";

/** @type {import('./$types').PageLoad} */
export async function load({ params }) {
    let airport = await getAirportFromIata(params.slug);
    if (airport) {
        return airport;
    }

    error(404, 'Not found');
}