import {TextField} from "@mui/material";


export default function NIPInput() {
    return (
        <TextField
            required
            id="nip"
            label="NIP"
            variant="outlined"
        />
    );
}