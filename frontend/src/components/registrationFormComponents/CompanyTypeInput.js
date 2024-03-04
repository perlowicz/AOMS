import {TextField} from "@mui/material";


export default function CompanyTypeInput() {
    return (
        <TextField
            id="company-type-input"
            label="Rodzaj prowadzonej działalności"
            variant="outlined"
            required
            helperText="Według PKD (Polska Klasyfikacja Działalności)"
        />
    );
}