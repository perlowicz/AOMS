import {TextField} from "@mui/material";


export default function CompanyAddressStreetNumberInput() {
    return (
        <TextField
            required
            id="streetNumber"
            label="Numer ulicy"
            variant="outlined"
            type="number"
        />
    );
}