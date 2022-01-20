<script lang="ts">
    export let name:String = "";
    export let count:Number = 0;
</script>

<div class="main">
    <div>{name}</div>
    <p>{count}</p>
</div>

<style>
    div.main {
        flex: 1;
        text-align: center;
        padding: 2em;
    }

    div.main div {
        font-weight: bold;
    }
</style>