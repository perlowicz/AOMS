import React, {useState} from "react";
import axios from "axios";
import {Link, useNavigate} from "react-router-dom";

export default function AddClient() {

    let navigate = useNavigate();

    const [client, setClient] = useState({
        invoiceNumber: "",
        // FIXME The missing inputs that will come here from form should be added.
    })

    const {
        invoiceNumber,
        // FIXME The missing inputs that will come here from form should be added.
    } = client;

    const onInputChange = (e) => {
        setClient({...client, [e.target.name]: e.target.value});
    };

    const onSubmit = async (e) => {
        e.preventDefault();
        await axios.post("http://localhost:8080/client", client);
        navigate("/");
    };

    return (
        <div className="container">
            <div className="row">
                <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow">
                    <h2 className="text-center m-4">Register Client</h2>
                    <form onSubmit={(e) => onSubmit(e)}>
                        {/*
                        FIXME The div below represents one input from form, missing inputs should be added.
                        */}
                        <div className="mb-3">
                            <label htmlFor="invoiceNumber" className="form-label">
                                Invoice Number
                            </label>
                            <input
                                type={"text"}
                                className="form-control"
                                placeholder="Enter Invoice Number"
                                name="invoiceNumber"
                                value={invoiceNumber}
                                onChange={(e) => onInputChange(e)}
                            />
                        </div>
                        <button type="submit" className="btn btn-outline-primary">Submit</button>
                        <Link className="btn btn-outline-danger mx-2" to="/">Cancel</Link>
                    </form>
                </div>
            </div>
        </div>
    );
}