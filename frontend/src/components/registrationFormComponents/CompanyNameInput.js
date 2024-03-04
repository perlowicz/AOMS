import {TextField} from "@mui/material";


export default function CompanyNameInput() {
    return (
        <TextField
            id="company-name-input"
            label="Nazwa firmy"
            variant="outlined"
            required
        />
    );
}