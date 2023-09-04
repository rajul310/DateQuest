import React from "react";
import "./about.css";

const About = () => {
  return (
    <div>
      <div className="bg-dark">
        <div className="container text-white py-5">
          <div className="row h-100 align-items-center py-5">
            <div className="col-lg-6">
              <h1 className="display-4">About us</h1>
              <p className="lead mb-0">
              Welcome to DateQuest! We're your ultimate destination for crafting unforgettable experiences with your beloved. Our innovative web application is designed to effortlessly plan and curate unique, romantic outings that spark joy and deepen connections. Let us help you create cherished memories, one perfect date at a time.
              </p>
            </div>
            <div className="col-lg-6 d-none d-lg-block">
              <img src="images/about.png" alt="" className="img-fluid" />
            </div>
          </div>
        </div>
      </div>

      <div className="bg-white py-5">
        <div className="container py-5">
          <div className="row align-items-center mb-5">
            <div className="col-lg-6 order-2 order-lg-1">
              <i className="fas fa-heartbeat fa-2x mb-3 text-primary"></i>
              <h2 className="font-weight-light">What is DateQuest?</h2>
              <p className="font-italic text-muted mb-4">
              DateQuest is a user-friendly and innovative web application that takes the hassle out of planning romantic outings with your loved one. Whether you're embarking on a first date or celebrating a special milestone, DateQuest offers a curated selection of creative date ideas tailored to your preferences. From cozy dinners under the stars to adventurous escapades, our platform provides you with the tools to design memorable experiences that nurture your relationship and create lasting memories. Say goodbye to the stress of planning and hello to delightful, personalized dates with DateQuest.
              </p>
            </div>
            <div className="col-lg-5 px-5 mx-auto order-1 order-lg-2">
              <img
                src="images/healthify.jpg"
                alt=""
                className="img-fluid mb-4 mb-lg-0"
              />
            </div>
          </div>
          <div className="row align-items-center">
            <div className="col-lg-5 px-5 mx-auto">
              <img
                src="images/more.png"
                alt=""
                className="img-fluid mb-4 mb-lg-0"
              />
            </div>
            <div className="col-lg-6">
              <i className="fas fa-mortar-pestle fa-2x mb-3 text-primary"></i>
              <h2 className="font-weight-light">More than just an app</h2>
              <p className="font-italic text-muted mb-4">
              "DateQuest is also for Date Planners vendors who are willing to represent and want
               to add-ons on their package details by providing attractive offers.
               Add package details for a dating package so that it stands out."
              
              </p>
            </div>
          </div>
        </div>
      </div>

      <div className="bg-dark py-5">
        <div className="container py-5">
          <div className="row mb-4">
            <div className="col-lg-5">
              <h2 className="display-4 font-weight-light text-white">
                Our team
              </h2>
              <p className="font-italic text-light">
                Meet our veterans from various domains.
              </p>
              <p className="lead text-muted">Designed with love in India.</p>
            </div>
          </div>

          <div className="row text-center">
            <div className="col-xl-3 col-sm-6 mb-5">
              <div className="bg-white rounded shadow-sm py-5 px-4">
                <img
                  src="images/1.jpeg"
                  alt=""
                  width="100"
                  className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm"
                />
                <h5 className="mb-0">Rajul Gupta</h5>
                {/* <span className="small  text-muted">CEO - Founder</span> */}
                <ul className="social mb-0 list-inline mt-3">
                  <li className="list-inline-item">
                    <a href="!#" className="social-link">
                      <i className="fab fa-facebook-f"></i>
                    </a>
                  </li>
                  <li className="list-inline-item">
                    <a href="!#" className="social-link">
                      <i className="fab fa-instagram"></i>
                    </a>
                  </li>
                  <li className="list-inline-item">
                    <a href="!#" className="social-link">
                      <i className="fab fa-linkedin"></i>
                    </a>
                  </li>
                </ul>
              </div>
            </div>

            <div className="col-xl-3 col-sm-6 mb-5">
              <div className="bg-white rounded shadow-sm py-5 px-4">
                <img
                  src="images/5.jpeg"
                  alt=""
                  width="100"
                  className="img-fluid rounded-circle mb-3 img-thumbnail shadow-sm"
                />
                <h5 className="mb-0">Abhijeet Singh</h5>
                {/* <span className="small text-muted">Designer</span> */}
                <ul className="social mb-0 list-inline mt-3">
                  <li className="list-inline-item">
                    <a href="!#" className="social-link">
                      <i className="fab fa-facebook-f"></i>
                    </a>
                  </li>
                  <li className="list-inline-item">
                    <a href="!#" className="social-link">
                      <i className="fab fa-instagram"></i>
                    </a>
                  </li>
                  <li className="list-inline-item">
                    <a href="!#" className="social-link">
                      <i className="fab fa-linkedin"></i>
                    </a>
                  </li>
                </ul>
              </div>
            </div>
           
           

            
           
            
          </div>
        </div>
      </div>
    </div>
  );
};

export default About;
