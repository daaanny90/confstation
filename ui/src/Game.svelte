<script lang="ts">
    import Intro from './game/Intro.svelte'
    import Scanner from './game/Scanner.svelte'
    import App from './game/App.svelte'
    import Outro from './game/Outro.svelte'
    import {Status} from './game/Status'
    import {GameEvent} from "./game/GameEvent";

    let status:Status = Status.START

    function onStatus(event:Event) { onEvent(event.detail)}
    function onEvent(event:GameEvent) {
        if(event.status === Status.FINISH_OUTRO) {
            status = Status.START
            return;
        }
        status = event.status
    }
</script>

<div>
    {#if status === Status.START}
        <Intro status="{Status.FINISH_INTRO}" on:status={onStatus} />
    {/if}

    {#if status === Status.FINISH_INTRO}
        <Scanner status="{Status.FINISH_SCANNER}" on:status={onStatus} />
    {/if}

    {#if status === Status.FINISH_SCANNER}
        <App status="{Status.FINISH_APP}" on:status={onStatus} />
    {/if}

    {#if status === Status.FINISH_APP}
        <Outro status="{Status.FINISH_OUTRO}" on:status={onStatus} />
    {/if}
</div>

<style>
    div {
        padding:1em
    }
</style>