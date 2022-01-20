<script lang="ts">
    import { createEventDispatcher } from 'svelte';
    import {Status} from "./Status";
    import {GameEvent} from "./GameEvent";

    const dispatch = createEventDispatcher();
    export let status:Status

    function scanned() {
        dispatch('status', new GameEvent(status))
    }
</script>

<div>
    <h2>Scan your Id</h2>
    <div>
        <button on:click={scanned}>gescannt</button>
    </div>
</div>

<style>
    div {
        padding:1em
    }
</style>