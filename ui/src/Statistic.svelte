<script lang="ts">
    import Counter from './statistic/Counter.svelte'
    import {Service} from './statistic/Service'
    import {Info} from './statistic/Models'

    const service = new Service(confware?.env?.API_URL)

    export let eventId:string;
    export let stationId:string;

    let teilnehmerStation: Number = 0
    let teilnehmer: Number = 0
    let interaktionen: Number = 0
    let gewinner: Number = 0
    let teilnehmerinGewinnzone: Number = 0

    function call() : Promise<void> {
        return new Promise((resolve, reject) => {
            service.getInfo(eventId, stationId)
                .then((info:Info) => {
                    teilnehmerStation = info.teilnehmerStation
                    teilnehmer = info.teilnehmer
                    interaktionen = info.interaktionen
                    gewinner = info.gewinner
                    teilnehmerinGewinnzone = info.teilnehmerinGewinnzone
                    resolve()
                })
        });
    }

    call().then(() => setInterval(call, 10000))

</script>

<div>
    <Counter name="Teilnehmer an Station" count={teilnehmerStation} />
    <Counter name="Teilnehmer" count={teilnehmer} />
    <Counter name="Interaktionen" count={interaktionen} />
    <Counter name="Gewinner" count={gewinner} />
    <Counter name="Teilnehmer in der Gewinnzone" count={teilnehmerinGewinnzone} />
</div>

<style>
    div {
        display: flex;
        flex-direction: row;
        flex-grow: 4;
        background-color: #f9bf03;
    }
</style>