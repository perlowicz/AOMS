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
            <Typography>
                Numer faktury: {formData.number} <br/>
                Data faktury: {formData.date.format('YYYY-MM-DD')} <br/>
                Stawka podatku: {formData.taxRate} <br/>
                Stawka netto: {formData.nettoRate} <br/>
                Stawka brutto: {formData.bruttoRate} <br/>
                Łączna wartość: {formData.overallValue} <br/>
            </Typography>
            <Divider/>
            <Typography
                variant="h4"
            >
                Szczegóły firmy:
            </Typography>
            <Typography>
                Nazwa: {formData.company.name} <br/>
                NIP: {formData.company.nip} <br/>
                Kraj: {formData.company.country} <br/>
                Miasto: {formData.company.city} <br/>
                Ulica: {formData.company.streetName} <br/>
                Numer: {formData.company.streetNumber} <br/>
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
                Kraj: {formData.customer.country} <br/>
                Miasto: {formData.customer.city} <br/>
                Ulica: {formData.customer.streetName} <br/>
                Numer: {formData.customer.streetNumber} <br/>
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
                        Data dostarczenia towaru: {product.date.format('YYYY-MM-DD')} <br/>
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
                        Data poświadczenia usługi: {service.date.format('YYYY-MM-DD')} <br/>
                    </Typography>
                    <Divider/>
                </div>
            ))}
        </Container>
    );
}