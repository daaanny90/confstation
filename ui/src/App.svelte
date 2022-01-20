<script lang="ts">
	import Game from './Game.svelte'
	import Statistic from './Statistic.svelte'
	import Station from './Station.svelte'
	import Error from './Error.svelte'
	import Loading from './Loading.svelte'

    import {Service} from './station/Service'

    const params:URLSearchParams = new URLSearchParams(window.location.search)
    const eventId:String = params.get('eventId')
    const stationId:String = params.get('stationId')

    const stationService = new Service(confware?.env?.API_URL)

    let station = null;
    let error = null;

    stationService.getConfig(eventId, stationId)
        .then((res:Station) => {station = res})
        .catch((err) => {error = err})

</script>

{#if station}
    <header><Station station={station}/></header>
    <main><Game /></main>
    <footer><Statistic eventId={eventId} stationId={stationId}/></footer>
{:else if eventId && stationId}
    <Loading />
{:else}
    <Error />
{/if}


<style>
	main {
		flex:1
	}
</style>