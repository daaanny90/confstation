<script lang="ts">
	import Game from './Game.svelte'
	import Statistic from './Statistic.svelte'
	import Station from './Station.svelte'

    const params:URLSearchParams = new URLSearchParams(window.location.search)
    const eventId:String = params.get('eventId')
    const stationId:String = params.get('stationId')
</script>

{#if eventId && stationId}
    <header><Station /></header>
    <main><Game /></main>
    <footer><Statistic /></footer>
{:else}
    ERROR
{/if}


<style>
	main {
		flex:1
	}
</style>