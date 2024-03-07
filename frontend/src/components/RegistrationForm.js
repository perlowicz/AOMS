import Typography from "@mui/material/Typography";
import {FormLabel} from "@mui/material";
import IsVatGroup from "./registrationFormComponents/IsVatGroup";
import Box from "@mui/material/Box";
import CompanyNameInput from "./registrationFormComponents/CompanyNameInput";
import CompanyTypeInput from "./registrationFormComponents/CompanyTypeInput";
import CompanyOwnerNameInput from "./registrationFormComponents/CompanyOwnerNameInput";
import CompanyOwnerSurnameInput from "./registrationFormComponents/CompanyOwnerSurnameInput";
import NIPInput from "./registrationFormComponents/NIPInput";
import CompanyAddressCityInput from "./registrationFormComponents/CompanyAddressCityInput";
import CompanyAddressCountrySelect from "./registrationFormComponents/CompanyAddressCountrySelect";
import PostalCodeInput from "./registrationFormComponents/PostalCodeInput";
import CompanyAddressStreetInput from "./registrationFormComponents/CompanyAddressStreetInput";
import CompanyAddressStreetNumberInput from "./registrationFormComponents/CompanyAddressStreetNumberInput";
import Button from "@mui/material/Button";
import CompanyBankAccountNumber from "./registrationFormComponents/CompanyBankAccountNumber";


export default function RegistrationForm() {
    return (
        <Box
            component="form"
            autoComplete="off"
            sx={{
                display: 'flex',
                flexDirection: 'column',
                justifyContent: 'center',
                gap: 2,
                width: '100%',
                margin: 'auto',
                padding: '20px',
                borderRadius: '10px'

            }}
        >
            <FormLabel>
                <Typography
                    variant="h4"
                    align="center"
                >
                    Rejestracja firmy w Systemie
                </Typography>
            </FormLabel>
            <CompanyNameInput/>
            <CompanyTypeInput/>
            <CompanyOwnerNameInput/>
            <CompanyOwnerSurnameInput/>
            <NIPInput/>
            <CompanyBankAccountNumber/>
            <IsVatGroup/>
            <FormLabel>
                <Typography variant="h5">Adres firmy</Typography>
            </FormLabel>
            <CompanyAddressCountrySelect/>
            <CompanyAddressCityInput/>
            <PostalCodeInput/>
            <CompanyAddressStreetInput/>
            <CompanyAddressStreetNumberInput/>
            <Button
                type="submit"
                variant="contained"
            >
                Zatwiedź
            </Button>
        </Box>
    );
}