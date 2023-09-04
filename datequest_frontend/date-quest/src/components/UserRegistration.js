import { useForm } from 'react-hook-form';
import classNames from 'classnames';
import { useRef } from 'react';
import ApiService from '../services/ApiService';
import { useHistory } from 'react-router-dom';

const UserRegistration = () => {
    const history = useHistory();
    const { register, handleSubmit, formState: { errors }, watch } = useForm({ mode: "onChange" });
    const password = useRef({});
    password.current = watch("password", "");

    const submitHandler = (data) => {
        console.log(JSON.stringify(data));
        ApiService.doctorRegistration(data)
            .then(resp=>{
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
                'is-invalid': errors.userEmail,
              })}
              placeholder="User email"
              {...register('userEmail', {
                required: 'User email is required',
                pattern: {
                  value: /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/,
                  message: 'Invalid email format',
                },
              })}
            />
            {errors.userEmail && (
              <div className="invalid-tooltip">{errors.userEmail.message}</div>
            )}
          </div>
          <div className="col position-relative">
            <input
              type="text"
              className={classNames('form-control', {
                'is-invalid': errors.userName,
              })}
              placeholder="User name"
              {...register('userName', {
                required: 'User name is required',
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
            {errors.userName && (
              <div className="invalid-tooltip">{errors.userName.message}</div>
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
              'is-invalid': errors.userMobileNo,
            })}
            placeholder="Mobile"
            {...register('userMobileNo', {
              required: 'User mobile number is required',
              pattern: {
                value: /^[789]\d{9}$/,
                message: 'Invalid mobile number',
              },
            })}
          />
          {errors.userMobileNo && (
            <div className="invalid-tooltip">{errors.userMobileNo.message}</div>
          )}
        </div>
      </div>
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="text"
            className={classNames('form-control', {
              'is-invalid': errors.userAddress,
            })}
            placeholder="Address"
            {...register('userAddress', {
              required: 'User address is required',
              minLength: {
                value: 10,
                message: 'Should be at least 10 characters',
              },
            })}
          />
          {errors.userAddress && (
            <div className="invalid-tooltip">{errors.userAddress.message}</div>
          )}
        </div>
        <div className="col-4 position-relative">
          <input
            type="text"
            className={classNames('form-control', {
              'is-invalid': errors.userCity,
            })}
            placeholder="City"
            {...register('userCity', {
              required: 'User city is required',
              minLength: {
                value: 5,
                message: 'Should be at least 5 characters',
              },
            })}
          />
          {errors.userCity && (
            <div className="invalid-tooltip">{errors.userCity.message}</div>
          )}
        </div>
      </div>
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="date"
            className={classNames('form-control', {
              'is-invalid': errors.userDob,
            })}
            placeholder="Date of Birth"
            {...register('userDob', {
              required: 'User date of birth is required',
            })}
          />
          {errors.userDob && (
            <div className="invalid-tooltip">{errors.userDob.message}</div>
          )}
        </div>
      </div>

      {/* User Age */}
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="number"
            className={classNames('form-control', {
              'is-invalid': errors.userAge,
            })}
            placeholder="Age"
            {...register('userAge', {
              required: 'User age is required',
              min: {
                value: 18,
                message: 'User must be at least 18 years old',
              },
              max: {
                value: 120,
                message: 'User age cannot be more than 120',
              },
            })}
          />
          {errors.userAge && (
            <div className="invalid-tooltip">{errors.userAge.message}</div>
          )}
        </div>
      </div>

      {/* User Gender */}
      <div className="form-group">
        <div className="col position-relative">
          <select
            className={classNames('form-control', {
              'is-invalid': errors.userGender,
            })}
            {...register('userGender', {
              required: 'User gender is required',
            })}
          >
            <option value="">Select Gender</option>
            <option value="MALE">Male</option>
            <option value="FEMALE">Female</option>
            <option value="OTHER">Other</option>
          </select>
          {errors.userGender && (
            <div className="invalid-tooltip">{errors.userGender.message}</div>
          )}
        </div>
      </div>

      {/* User Government ID */}
      <div className="form-group">
        <div className="col position-relative">
          <input
            type="number"
            className={classNames('form-control', {
              'is-invalid': errors.userGovtId,
            })}
            placeholder="Government ID"
            {...register('userGovtId', {
              required: 'User government ID is required',
            })}
          />
          {errors.userGovtId && (
            <div className="invalid-tooltip">{errors.userGovtId.message}</div>
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

export default UserRegistration;