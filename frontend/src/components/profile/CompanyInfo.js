import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";

const companyAddress = {
    streetName: "Świerkowa",
    streetNumber: 23,
    city: "Kuklówka",
    postalCode: "05-077",
    country: "Polska",
};

const companyInfo = {
    companyName: "Firma",
    companyType: "Sp. z o.o.",
    companyOwnerFirstName: "Bartłomiej",
    companyOwnerSecondName: "Perliński",
    companyNIP: "NIP firmy",
    companyBankAccount: "12345678901234567890123456",
    companyIsVatGroup: true,
    companyAddress: companyAddress,
};

export default function CompanyInfo() {
    return (
        <Box>
            <Typography>Profil firmy</Typography>
        </Box>
    );
}