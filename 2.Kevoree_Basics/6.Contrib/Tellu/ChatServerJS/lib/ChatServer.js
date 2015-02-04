// if you have already created your own Component extending AbstractComponent
// you can replace AbstractComponent here and use your own
// ex: var MyComp = require('./path/to/MyComp')
// the only thing needed is that the top level component extends AbstractComponent :)
var AbstractComponent = require('kevoree-entities').AbstractComponent;

/**
 * Kevoree component
 * @type {ChatServer}
 */
var ChatServer = AbstractComponent.extend({
    toString: 'ChatServer',

    /* This is an example of dictionary attribute that you can set for your entity */
    //dic_yourAttrName: {
    //  optional: true,
    //  defaultValue: false
    //},

    /**
     * this method will be called by the Kevoree platform when your component has to start
     * @param {Function} done
     */
    start: function (done) {
        this._super(function () {
            // TODO
            this.log.debug(this.toString(), 'START');
            done();
        }.bind(this));
    },

    /**
     * this method will be called by the Kevoree platform when your component has to stop
     * @param {Function} done
     */
    stop: function (done) {
        this._super(function () {
            // TODO
            this.log.debug(this.toString(), 'STOP');
            done();
        }.bind(this));
    },
	
	 /**
     * Output port declaration - "chatClients"
     * @param {String} msg    Greeting message to send to others
     */
    out_chatClients: function () { /* This will be overwritten @runtime by Kevoree JS */ },
    
    in_input: function (msg) {
	
    	console.log(this.getName() + '>' + msg);
		this.log.debug(this.getName() + '>' + msg);
    	this.out_chatClients(msg +' from ' + this.getName());        
    
    }
});

module.exports = ChatServer;
