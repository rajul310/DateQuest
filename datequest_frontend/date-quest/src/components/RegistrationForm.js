import { useState } from "react";
import "./registration.css";
import { Link } from "react-router-dom";
import UserRegistration from "./UserRegistration";
import VendorRegistration from "./VendorRegistration";

const RegistrationForm = () => {
  const [activeButton, setActiveButton] = useState("user");
  const clickHandler = (e) => {
    setActiveButton(e.target.value);
  };
  return (
    <div className="container-fluid ps-md-0" style={{ marginTop: "56px" }}>
      <div className="row g-0">
        <div className="d-none d-md-flex col-md-4 col-lg-6 bg-image-reg"></div>
        <div className="col-md-8 col-lg-6">
          <div className="login d-flex align-items-center py-0">
            <div className="container">
              <div className="row">
                <div className="col-md-9 col-lg-8 mx-auto">
                  <div className="text-center my-container-reg">
                    <h1 className="display-6 mb-3">Register Now!</h1>
                    <div className="col-lg-6 mx-auto">
                      <div className="d-grid gap-2 d-sm-flex justify-content-sm-center">
                        <button
                          type="button"
                          className={`btn btn-sm btn-outline-dark btn-lg px-3 shadow-none ${
                            activeButton === "vendor" ? "active" : ""
                          }`}
                          onClick={clickHandler}
                          value="vendor"
                        >
                          Vendor
                        </button>
                        <button
                          type="button"
                          className={`btn btn-sm btn-outline-dark btn-lg px-3 shadow-none ${
                            activeButton === "user" ? "active" : ""
                          }`}
                          onClick={clickHandler}
                          value="user"
                        >
                          User
                        </button>
                      </div>
                    </div>
                    <div className="signup-form">
                      {activeButton === "vendor" ? (
                        <VendorRegistration />
                      ) : (
                        <UserRegistration />
                      )}
                      <div className="hint-text">
                        Already have an account?{" "}
                        <Link to="/login" style={{ textDecoration: "none" }}>
                          <span>Login here</span>
                        </Link>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default RegistrationForm;
