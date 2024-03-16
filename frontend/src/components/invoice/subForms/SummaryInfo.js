import Container from "@mui/material/Container";
import Typography from "@mui/material/Typography";
import {Divider} from "@mui/material";


export default function SummaryInfo( {formData} ) {

    return (
        <Container>
            <Typography>
                Podsumowanie:
            </Typography>
            <Typography
                variant="h4"
            >
                Szczegóły faktury:
            </Typography>
            {/*<Typography>*/}
            {/*    Numer faktury: {formData.invoiceDetails.number} <br/>*/}
            {/*    Data faktury: {formData.invoiceDetails.date} <br/>*/}
            {/*    Stawka podatku: {formData.invoiceDetails.taxRate} <br/>*/}
            {/*    Stawka netto: {formData.invoiceDetails.nettoRate} <br/>*/}
            {/*    Stawka brutto: {formData.invoiceDetails.bruttoRate} <br/>*/}
            {/*    Łączna wartość: {formData.invoiceDetails.overallValue} <br/>*/}
            {/*</Typography>*/}
            <Divider/>
            <Typography
                variant="h4"
            >
                Szczegóły firmy:
            </Typography>
            <Typography>
                Nazwa: {formData.company.name} <br/>
                NIP: {formData.company.nip} <br/>
                Kraj: {formData.company.address.country.country} <br/>
                Miasto: {formData.company.address.city} <br/>
                Ulica: {formData.company.address.streetName} <br/>
                Numer: {formData.company.address.streetNumber} <br/>
            </Typography>
            <Divider/>
            <Typography
                variant="h4"
            >
                Szczegóły klienta:
            </Typography>
            <Typography>
                Nazwa: {formData.customer.name} <br/>
                NIP: {formData.customer.nip} <br/>
                Kraj: {formData.customer.address.country.country} <br/>
                Miasto: {formData.customer.address.city} <br/>
                Ulica: {formData.customer.address.streetName} <br/>
                Numer: {formData.customer.address.streetNumber} <br/>
            </Typography>
            <Divider/>
            <Typography
                variant="h4"
            >
                Towary na fakturze:
            </Typography>
            {formData.listOfProductInvoiceInfo.map((product, index) => (
                <div key={index}>
                    <Typography>
                        Nazwa: {product.name} <br/>
                        Ilość: {product.quantity} <br/>
                        Cena brutto: {product.bruttoPrice} <br/>
                        Cena netto: {product.nettoPrice} <br/>
                        Data dostarczenia towaru: {product.date} <br/>
                    </Typography>
                    <Divider/>
                </div>
            ))}
            <Typography
                variant="h4"
            >
                Usługi na fakturze:
            </Typography>
            {formData.listOfServiceInvoiceInfo.map((service, index) => (
                <div key={index}>
                    <Typography>
                        Nazwa: {service.name} <br/>
                        Zakres: {service.scope} <br/>
                        Cena brutto: {service.bruttoPrice} <br/>
                        Cena netto: {service.nettoPrice} <br/>
                        Data poświadczenia usługi: {service.date} <br/>
                    </Typography>
                    <Divider/>
                </div>
            ))}
        </Container>
    );
}