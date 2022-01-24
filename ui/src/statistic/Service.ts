import type {Info} from './Models'

export class Service {
    private apiUrl:string

    constructor(apiUrl:string) {
        this.apiUrl = apiUrl;
    }

    getInfo(eventId:string, stationId:string) {
        return new Promise((resolve, reject) => {
            fetch(`${this.apiUrl}event/${eventId}/station/${stationId}/statistic`)
                .then((res) => {
                    res.json()
                        .then((obj:Object) => {
                            let station = <Info>obj
                            resolve(station)
                        })
                        .catch(reject)
                })
                .catch(reject)
        });
    }
}