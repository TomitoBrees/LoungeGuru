import {refreshUser} from "$lib/services/userService.js";
import {getAllAirports} from "$lib/services/airportService.js";

let cachedAirports = null;
let lastCached = null;
const cachedLifetime = 5 * 60 * 1000;

/** @type {import('./$types').LayoutServerLoad} */
export async function load({ cookies, fetch }) {

    let user = await refreshUser(cookies, fetch);
    let airports = await getAllAirports({cachedAirports, lastCached, cachedLifetime});

    console.log(user);

    return {user: user, airports: airports}
}