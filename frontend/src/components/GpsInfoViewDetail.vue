<template>

    <v-card outlined>
        <v-card-title>
            GpsInfo # {{$route.params.id }}
        </v-card-title>

        <v-card-text>
            <div>
                <Date label="Time" v-model="item.time" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="X" v-model="item.x" :editMode="editMode" @change="change" />
            </div>
            <div>
                <String label="Y" v-model="item.y" :editMode="editMode" @change="change" />
            </div>
            <div>
                <Number label="PhoneId" v-model="item.phoneId" :editMode="editMode" @change="change" />
            </div>
        </v-card-text>
    </v-card>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'GpsInfoViewDetail',
    props: {
      value: Object,
    },
    data: () => ({
        item : [],
    }),
    async created() {
      var params = this.$route.params;
      var temp = await axios.get(axios.fixUrl('/gpsInfos/' + params.id))

      this.item = temp.data;

    },
    methods: {
    }
  }
</script>

