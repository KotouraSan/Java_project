import React, { useState } from "react";
import "./styles.css";
import { districts, urlPort } from "../../constants";

const ProfilePage = () => {
  const [email, setEmail] = useState("");
  const [district, setDistrict] = useState("");
  const [name, setName] = useState("");
  const [phone, setPhone] = useState("");
  const [isSigningUp, setIsSigningUp] = useState(false);

  const token = localStorage.getItem("token");

  const saveUserToLocalStorage = (userData) => {
    localStorage.setItem("token", userData.token);
    localStorage.setItem("customerFullName", userData.customerFullName || name);
    localStorage.setItem("customerEmail", userData.customerEmail || email);
    localStorage.setItem("customerPhone", userData.customerPhone || phone);
    localStorage.setItem(
      "customerDistrict",
      userData.customerDistrict || district
    );
  };

  const handleSignUp = async (e) => {
    e.preventDefault();
    try {
      const url = `${urlPort}customer/`;
      const response = await fetch(url, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          customerFullName: name,
          customerEmail: email,
          customerPhone: phone,
          customerDistrict: district,
        }),
      });
      const data = await response.json();

      if (response.ok) {
        saveUserToLocalStorage({
          token: data.token,
          customerFullName: name,
          customerEmail: email,
          customerPhone: phone,
          customerDistrict: district,
        });

        setIsSigningUp(true);
      }
    } catch (error) {
      console.error(error);
    }
  };

  const handleLogin = async (e) => {
    e.preventDefault();
    try {
      const url = `${urlPort}customer/full/${email}`;
      const response = await fetch(url);
      const data = await response.json();

      if (response.ok) {
        saveUserToLocalStorage({
          token: data.token,
          customerFullName: data.customerFullName,
          customerEmail: data.customerEmail,
          customerPhone: data.customerPhone,
          customerDistrict: data.customerDistrict,
        });

        setIsSigningUp(true);
      }
    } catch (error) {
      console.error(error);
    }
  };

  return (
    <div>
      {token || isSigningUp ? (
        <div className="login_page_container"></div>
      ) : (
        <div className="login_page_container">
          <div className="login_page">
            <input type="checkbox" id="chk" aria-hidden="true" />
            <div className="signup">
              <form onSubmit={handleSignUp}>
                <label htmlFor="chk" aria-hidden="true">
                  Sign up
                </label>
                <input
                  type="text"
                  name="name"
                  placeholder="User name"
                  value={name}
                  onChange={(e) => setName(e.target.value)}
                  required
                />
                <input
                  type="email"
                  name="email"
                  placeholder="Email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
                <input
                  type="number"
                  name="phone"
                  placeholder="Phone number"
                  value={phone}
                  onChange={(e) => setPhone(e.target.value)}
                  required
                />
                <select
                  name="district"
                  value={district}
                  onChange={(e) => setDistrict(e.target.value)}
                  className="district_input"
                >
                  <option value="" disabled>
                    Select a district
                  </option>
                  {districts.map((company) => (
                    <option key={company.id} value={company.id}>
                      {company.name}
                    </option>
                  ))}
                </select>
                <button type="submit">Sign up</button>
              </form>
            </div>
            <div className="login">
              <form onSubmit={handleLogin}>
                <label htmlFor="chk" aria-hidden="true">
                  Login
                </label>
                <input
                  type="email"
                  name="email"
                  placeholder="Email"
                  value={email}
                  onChange={(e) => setEmail(e.target.value)}
                  required
                />
                <button type="submit">Login</button>
              </form>
            </div>
          </div>
        </div>
      )}
    </div>
  );
};

export default ProfilePage;
