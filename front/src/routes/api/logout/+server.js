export async function POST({ cookies }) {
    cookies.delete('accessToken', { path: '/' });
    cookies.delete('refreshToken', { path: '/' });
    return new Response(null, { status: 200 });
}