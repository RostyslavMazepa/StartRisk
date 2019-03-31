<template>
    <div>
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
            <b-form-group
                    id="input-group-first-name"
                    label="First name:"
                    label-for="input-first-name"
                    description="We'll never share your email with anyone else."
            >
                <b-form-input
                        id="input-first-name"
                        v-model="form.firstName"
                        required
                        placeholder="First name"
                ></b-form-input>
            </b-form-group>

            <b-form-group
                    id="input-group-middle-name"
                    label="Middle name:"
                    label-for="input-first-name"
            >
                <b-form-input
                        id="input-middle-name"
                        v-model="form.middleName"
                        required
                        placeholder="Middle name"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-last-name"
                          label="Last Name:"
                          label-for="input-last-name">
                <b-form-input
                        id="input-last-name"
                        v-model="form.lastName"
                        required
                        placeholder="Last name"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-birth-date"
                          label="Birth Date:"
                          label-for="input-birth-date">
                <b-form-input
                        id="input-birth-date"
                        v-model="form.birthDate"
                        required
                        type="date"
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-sex" label="Sex:" label-for="input-sex">
                <b-form-select
                        id="input-sex"
                        v-model="form.sex"
                        :options="sexs"
                        required
                ></b-form-select>
            </b-form-group>

            <b-button type="submit" variant="primary">Submit</b-button>
            <b-button type="reset" variant="danger">Reset</b-button>
        </b-form>
    </div>
</template>

<script>
    import {AXIOS} from './http-common'

    export default {
        name: "person",
        data() {
            return {
                response: [],
                errors: [],
                form: {
                    firstName: '',
                    middleName:'',
                    lastName: '',
                    birthDate: '',
                    sex: null,
                },
                sexs: [{ text: 'Select one', value: null }, { text: 'Female', value: 0 }, { text: 'Male', value: 1}],
                show: true,
                showResponse: false
            }
        },
        methods: {
            onSubmit(evt) {
                evt.preventDefault();
                alert(JSON.stringify(this.form));
                this.createPerson();
            },
            onReset(evt) {
                evt.preventDefault();
                // Reset our form values
                this.form.firstName = '';
                this.form.middleName = '';
                this.form.lastName = '';
                this.form.birthDate = '';
                this.form.sex = null;
                // Trick to reset/clear native browser form validation state
                this.show = false;
                this.$nextTick(() => {
                    this.show = true
                })
            },
            createPerson(){
                var params = new URLSearchParams();
                params.append('firstName',this.form.firstName);
                params.append('middleName', this.form.middleName);
                params.append('lastName', this.form.lastName);
                params.append('birthDate', this.form.birthDate);
                params.append('sex', this.form.sex);

                AXIOS.post(`/person`, params)
                    .then(response => {
                        // JSON responses are automatically parsed.
                        this.response = response.data;
                        this.user.id = response.data;
                        console.log(response.data);
                        this.showResponse = true
                    })
                    .catch(e => {
                        this.errors.push(e)
                    })
            }
        }
    }
</script>

<style scoped>

</style>