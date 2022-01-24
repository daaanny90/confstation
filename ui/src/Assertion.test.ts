import {Assertion} from "./Assertion";


describe("Assertions", () => {
    it("assert Success", () => {
        Assertion.assert(true, 'msg')
    })

    it("assert Fail", () => {
        expect(() => Assertion.assert(false, 'msg')).toThrowError("msg");
    })

    it("notEmptyString", () => {
        Assertion.notEmptyString("Hallo")
    })

    it.each([null, "", " "])("notEmptyString Fail", (it) => {
        expect(() => Assertion.notEmptyString(it)).toThrowError("Value not a string or empty");
    })
})