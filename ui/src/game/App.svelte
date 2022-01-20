<script lang="ts">
    import {Status} from "./Status";
    import {createEventDispatcher} from "svelte";
    import {GameEvent} from "./GameEvent";

    const dispatch = createEventDispatcher();
    export let status:Status

    function weiter() {
        dispatch('status', new GameEvent(status))
    }
</script>

<div>
    App Includeing
    <ul>
        <li>call to create a game</li>
        <li>show game</li>
        <li>and finish game</li>
    </ul>
    <div>
        <button on:click={weiter}>weiter</button>
    </div>
</div>

<style>
    div {
        padding:1em
    }
</style>