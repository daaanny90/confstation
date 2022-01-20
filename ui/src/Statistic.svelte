<script lang="ts">
    import Counter from './statistic/Counter.svelte'
</script>

<div>
    <Counter name="Teilnehmer an Station" count="0" />
    <Counter name="Teilnehmer" count="0" />
    <Counter name="Interaktionen" count="0" />
    <Counter name="Gewinner" count="0" />
    <Counter name="Teilnehmer in der Gewinnzone" count="0" />
</div>

<style>
    div {
        display: flex;
        flex-direction: row;
        flex-grow: 4;
        background-color: #f9bf03;
    }
</style>