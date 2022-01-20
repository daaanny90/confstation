<script lang="ts">
    import { createEventDispatcher } from 'svelte';
    import {Status} from "./Status";
    import {GameEvent} from "./GameEvent";

    const dispatch = createEventDispatcher();
    export let status:Status

    function start() {
        dispatch('status', new GameEvent(status))
    }
</script>

<div>
    <h2>Beautyful App Teaser</h2>
    <h2>Play Your Game.</h2>
    <p>
        Provide an overview of this Game Level benefits. <br/>
        <br/>
        Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt.
    </p>
    <div>
        <button on:click={start}>start</button>
    </div>
</div>

<style>
    div {
        padding:1em
    }
</style>