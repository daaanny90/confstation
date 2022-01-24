export class Assertion {
    private constructor() {}

    static assert(expr, msg:string) {
        if (!expr) {
            throw new AssertionError(msg)
        }
    }

    static notEmptyString(value:string) {
        this.assert(typeof value === 'string' && value.trim().length > 0, "Value not a string or empty")
    }
}

export class AssertionError extends Error {}