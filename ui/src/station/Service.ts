import type {Station} from './Models'

export class Service {
    private apiUrl:string

    constructor(apiUrl:string) {
        this.apiUrl = apiUrl;
    }

    getConfig(eventId:string, stationId:string) {
        return new Promise((resolve, reject) => {
            fetch(this.apiUrl + `/event/${eventId}/station/${stationId}`)
                .then((res) => {
                    res.json()
                        .then((obj:Object) => {
                            let station = <Station>obj
                            resolve(station)
                        })
                        .catch(reject)
                })
                .catch(reject)
        });
    }
}