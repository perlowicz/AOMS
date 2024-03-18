import {TextField} from "@mui/material";

export default function PasswordInput() {
    return (
        <TextField
            required
            id="password-input"
            label="Hasło"
            type="password"
            autoComplete="current-password"
        />
    );
}