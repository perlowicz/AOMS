import {TextField} from "@mui/material";

export default function EmailInput() {
    return (
        <TextField
            required
            id="email-input"
            label="Email"
            variant="outlined"
        />
    );
}