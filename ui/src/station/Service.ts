import type {Station} from './Models'
import {Assertion} from "../Assertion";

export class Service {
    private apiUrl:string

    constructor(apiUrl:string) {
        this.apiUrl = apiUrl;
    }

    getConfig(eventId:string, stationId:string) {
        return new Promise((resolve, reject) => {
            try {
                Assertion.notEmptyString(eventId)
                Assertion.notEmptyString(stationId)

                fetch(`${this.apiUrl}event/${eventId}/station/${stationId}`)
                    .then((res) => {
                        res.json()
                            .then((obj: Object) => {
                                let station = <Station>obj
                                resolve(station)
                            })
                            .catch(reject)
                    })
                    .catch(reject)
            } catch (e) {
                reject(e);
            }
        });
    }
}