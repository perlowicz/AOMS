import {Navigate} from "react-router-dom";


export default function ProtectedRoute ({ user, children }) {
    if (user) {
        return children;
    } else {
        return <Navigate to="/login"/>;
    }
}