<script lang="ts">
    import {Status} from "./Status";
    import {createEventDispatcher} from "svelte";
    import {GameEvent} from "./GameEvent";

    const dispatch = createEventDispatcher();
    export let status:Status

    function ok() {
        dispatch('status', new GameEvent(status))
    }
</script>

<div>
    Outro

    <div>
        <button on:click={ok}>ok</button>
    </div>
</div>

<style>
    div {
        padding:1em
    }
</style>