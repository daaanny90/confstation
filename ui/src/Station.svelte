<script lang="ts">
    export let station:Station

    $: logoStationSrc = station?.logo?.src || null
    $: logoStationTitle = station?.logo?.title || null
    $: logoEventSrc = station?.event?.logo?.src || ""
    $: logoEventTitle = station?.event?.logo?.title || ""
</script>

<div class="main">
    <div>
        {#if logoStationSrc}
            <img src="{logoStationSrc}" alt="{logoStationTitle}" />
        {/if}
    </div>
    <div>
        {#if logoEventSrc}
            <img src="{logoEventSrc}" alt="{logoEventTitle}" />
        {/if}
    </div>
    <div>

    </div>
</div>

<style>
    div.main {
        display: flex;
        flex-direction: row;
        flex-grow: 3;
        background-color: #f9bf03;
    }

    div.main div {
        flex:1;
    }
</style>