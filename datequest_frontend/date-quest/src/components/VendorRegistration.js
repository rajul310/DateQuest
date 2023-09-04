import { useForm } from 'react-hook-form';
import classNames from 'classnames';
import { useRef } from 'react';
import ApiService from '../services/ApiService';
import { useHistory } from 'react-router-dom';

const VendorRegistration = () => {

    const history = useHistory();
    const { register, handleSubmit, formState: { errors }, watch } = useForm({ mode: "onChange" });
    const password = useRef({});
    password.current = watch("password", "");

    const submitHandler = (data) => {
        console.log(JSON.stringify(data));
        ApiService.patRegistration(data)
            .then(resp=>{
                console.log(resp.data);
                history.push({
                    pathname: '/login',
                    state: { message: resp.data }
                });
            }).catch(err => {
                console.log(err);
            })
    }  

    return (
        <form onSubmit={handleSubmit(submitHandler)} method="post" className="needs-validation" noValidate autoComplete="off">
            <p>Please fill in this form to create an account!</p>
            <hr />
            <div className="form-group">
                <div className="row">
                <div className="col position-relative">
            <input
              type="email"
              className={classNames('form-control', {
                'is-invalid': errors.vendorEmail,
              })}
              placeholder="Vendor email"
              {...register('vendorEmail', {
                required: 'Vendor email is required',
                pattern: {
                  value: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                  message: 'Invalid email format',
                },
              })}
            />
            {errors.vendorEmail && (
              <div className="invalid-tooltip">{errors.vendorEmail.message}</div>
            )}
          </div>
          <div className="col position-relative">
            <input
              type="text"
              className={classNames('form-control', {
                'is-invalid': errors.vendorName,
              })}
              placeholder="Vendor name"
              {...register('vendorName', {
                required: 'Vendor name is required',
                minLength: {
                  value: 4,
                  message: 'Should be at least 4 characters',
                },
                pattern: {
                  value: /^(?![\. ])[a-zA-Z\. ]+(?<! )$/,
                  message: 'Invalid name',
                },
              })}
            />
            {errors.vendorName && (
              <div className="invalid-tooltip">{errors.vendorName.message}</div>
            )}
          </div>
        </div>
      </div>
      <div className="form-group">
        <div className="row">
          <div className="col position-relative">
            <input
              type="password"
              className={classNames('form-control', {
                'is-invalid': errors.password,
              })}
              placeholder="Password"
              {...register('password', {
                required: 'Please enter your password.',
                minLength: {
                  value: 8,
                  message: 'Should be at least 8 characters',
                },
              })}
            />
            {errors.password && (
              <div className="invalid-tooltip">{errors.password.message}</div>
            )}
          </div>
          <div className="col position-relative">
            <input
              type="password"
              className={classNames('form-control', {
                'is-invalid': errors.confirm_password,
              })}
              placeholder="Confirm Password"
              {...register('confirm_password', {
                validate: (value) =>
                  value === password || 'The passwords do not match',
              })}
            />
            {errors.confirm_password && (
              <div className="invalid-tooltip">
                {errors.confirm_password.message}
              </div>
            )}
          </div>
        </div>
      </div>
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="tel"
            className={classNames('form-control', {
              'is-invalid': errors.vendorMobileNo,
            })}
            placeholder="Mobile"
            {...register('vendorMobileNo', {
              required: 'Vendor mobile number is required',
              pattern: {
                value: /^[789]\d{9}$/,
                message: 'Invalid mobile number',
              },
            })}
          />
          {errors.vendorMobileNo && (
            <div className="invalid-tooltip">{errors.vendorMobileNo.message}</div>
          )}
        </div>
      </div>
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="text"
            className={classNames('form-control', {
              'is-invalid': errors.vendorAddress,
            })}
            placeholder="Address"
            {...register('vendorAddress', {
              required: 'Vendor address is required',
              minLength: {
                value: 10,
                message: 'Should be at least 10 characters',
              },
            })}
          />
          {errors.vendorAddress && (
            <div className="invalid-tooltip">{errors.vendorAddress.message}</div>
          )}
        </div>
        <div className="col-4 position-relative">
          <input
            type="text"
            className={classNames('form-control', {
              'is-invalid': errors.vendorCity,
            })}
            placeholder="City"
            {...register('vendorCity', {
              required: 'Vendor city is required',
              minLength: {
                value: 5,
                message: 'Should be at least 5 characters',
              },
            })}
          />
          {errors.vendorCity && (
            <div className="invalid-tooltip">{errors.vendorCity.message}</div>
          )}
        </div>
      </div>
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="date"
            className={classNames('form-control', {
              'is-invalid': errors.vendorDob,
            })}
            placeholder="Date of Birth"
            {...register('vendorDob', {
              required: 'Vendor date of birth is required',
            })}
          />
          {errors.vendorDob && (
            <div className="invalid-tooltip">{errors.vendorDob.message}</div>
          )}
        </div>
      </div>

      {/* Vendor Age */}
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="number"
            className={classNames('form-control', {
              'is-invalid': errors.vendorAge,
            })}
            placeholder="Age"
            {...register('vendorAge', {
              required: 'Vendor age is required',
              min: {
                value: 18,
                message: 'Vendor must be at least 18 years old',
              },
              max: {
                value: 120,
                message: 'Vendor age cannot be more than 120',
              },
            })}
          />
          {errors.vendorAge && (
            <div className="invalid-tooltip">{errors.vendorAge.message}</div>
          )}
        </div>
      </div>

      {/* Vendor Gender */}
      <div className="form-group">
        <div className="col position-relative">
          <select
            className={classNames('form-control', {
              'is-invalid': errors.vendorGender,
            })}
            {...register('vendorGender', {
              required: 'Vendor gender is required',
            })}
          >
            <option value="">Select Gender</option>
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
            <option value="OTHER">Other</option>
          </select>
          {errors.vendorGender && (
            <div className="invalid-tooltip">{errors.vendorGender.message}</div>
          )}
        </div>
      </div>

      {/* Vendor Government ID */}
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="number"
            className={classNames('form-control', {
              'is-invalid': errors.vendorGovtId,
            })}
            placeholder="Government ID"
            {...register('vendorGovtId', {
              required: 'Vendor government ID is required',
            })}
          />
          {errors.vendorGovtId && (
            <div className="invalid-tooltip">{errors.vendorGovtId.message}</div>
          )}
        </div>
      </div>
            <div className="form-group">
                <label className="form-check-label">
                    <input type="checkbox" className={classNames("form-check-input", {"is-invalid": errors.tnc})} name="tnc"
                        {...register('tnc', { 
                                required: "Please agree to the terms and conditions."
                            }
                        )} 
                    /> I hereby declare that the above information is true to the best of my knowledge.
                </label>
            </div>
            <div className="form-group">
                <button type="submit" className="btn btn-primary btn-lg text-dark">Sign Up</button>
            </div>
        </form>
    )
}

export default VendorRegistration;
