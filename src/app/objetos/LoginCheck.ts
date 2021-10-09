
export class LoginCheck {
    _email: String;
    _password: String;

    constructor(email: String, password: String) {
        this._email = email;
        this._password = password;
    }

    get password() {
        return this._password;
    }

    set password(password: String) {
        this._password = password;
    }

    get email() {
        return this._email;
    }

    set email(email: String) {
        this._email = email;
    }
}